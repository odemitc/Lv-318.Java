import { Component, OnInit } from '@angular/core';
import { MapsService } from '../../../../services/maps.service';
import { ActivatedRoute } from '@angular/router';
import { environment } from '../../../../../environments/environment';
import { Location, WaypointModel } from '../../../../models/waypoint.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-maps',
  templateUrl: './maps.component.html',
  styleUrls: ['./maps.component.css']
})
export class MapsComponent implements OnInit {
  firstFormGroup: FormGroup;
  public styles = [
    {
      'stylers': [
        {
          'saturation': -100
        },
        {
          'gamma': 1
        }
      ]
    },
    {
      'elementType': 'labels.text.stroke',
      'stylers': [
        {
          'visibility': 'off'
        }
      ]
    },
    {
      'featureType': 'poi.business',
      'elementType': 'labels.text',
      'stylers': [
        {
          'visibility': 'off'
        }
      ]
    },
    {
      'featureType': 'poi.business',
      'elementType': 'labels.icon',
      'stylers': [
        {
          'visibility': 'off'
        }
      ]
    },
    {
      'featureType': 'poi.place_of_worship',
      'elementType': 'labels.text',
      'stylers': [
        {
          'visibility': 'off'
        }
      ]
    },
    {
      'featureType': 'poi.place_of_worship',
      'elementType': 'labels.icon',
      'stylers': [
        {
          'visibility': 'off'
        }
      ]
    },
    {
      'featureType': 'road',
      'elementType': 'geometry',
      'stylers': [
        {
          'visibility': 'simplified'
        }
      ]
    },
    {
      'featureType': 'water',
      'stylers': [
        {
          'visibility': 'on'
        },
        {
          'saturation': 50
        },
        {
          'gamma': 0
        },
        {
          'hue': '#50a5d1'
        }
      ]
    },
    {
      'featureType': 'administrative.neighborhood',
      'elementType': 'labels.text.fill',
      'stylers': [
        {
          'color': '#333333'
        }
      ]
    },
    {
      'featureType': 'road.local',
      'elementType': 'labels.text',
      'stylers': [
        {
          'weight': 0.5
        },
        {
          'color': '#333333'
        }
      ]
    },
    {
      'featureType': 'transit.station',
      'elementType': 'labels.icon',
      'stylers': [
        {
          'gamma': 1
        },
        {
          'saturation': 50
        }
      ]
    }
  ];
  public transitId: string;
  public routeDirection = 'forward';
  public latStatic: Number = 49.84012222290039;
  public lngStatic: Number = 24.028803095222;
  public firstStopMarker: MarkerModel = new MarkerModel();
  public secondStopMarker: MarkerModel = new MarkerModel();
  public icon = environment.serverURL + '/category/img?link=static/bus-stop.png';
  public direction = undefined;
  public travelMode = 'DRIVING';
  private serviceUrl = environment.serverURL + '/stop';
  public points: any = undefined;
  public markers: MarkerModel[];
  public stopList: MarkerModel[];
  public zoom = 13;
  public renderOptions = {
    draggable: false,
    suppressMarkers: true,
    polylineOptions: {
      strokeColor: '#1c7bdb'
    }
  };
  public waypoints;

  public markerOptions = {
    origin: {
      icon: null,
      opacity: 0,
      scaledSize: 0.1,
    },
    destination: {
      icon: null,
      opacity: 0,
      scaledSize: 0.1,
    },
  };

  constructor(private route: ActivatedRoute, private service: MapsService, private _formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.route.params.forEach(param => {
      this.transitId = param['id'];
    });
    this.initPoints();
  }

  setDirectionAndRefresh(routeDirection) {
    this.routeDirection = routeDirection;
    this.initPoints();
    this.clearStopFirst();
    this.clearStopSecond();
  }

  initPoints() {
    this.service.getForwardDirection(this.transitId, this.routeDirection).subscribe(points => {
        this.points = points;
        console.log(points);
        this.markers = new Array(points.length);
        for (let i = 0; i < points.length; i++) {
          const marker: MarkerModel = new MarkerModel();
          marker.name = points[i].street;
          marker.lat = points[i].lat;
          marker.lng = points[i].lng;
          marker.draggable = false;
          marker.order = i;
          this.markers[i] = marker;
        }
        this.direction = {
          origin: {lat: points[0].lat, lng: points[0].lng},
          destination: {lat: points[points.length - 1].lat, lng: points[points.length - 1].lng}
        };
        this.waypoints = new Array(this.points.length - 2);
        for (let i = 1; i < points.length - 1; i++) {
          const waypoint: WaypointModel = new WaypointModel();
          const location: Location = new Location();
          location.lat = points[i].lat;
          location.lng = points[i].lng;
          waypoint.location = location;
          waypoint.stopover = true;
          this.waypoints[i - 1] = waypoint;
        }
      }
    )
    ;
  }

  clickedMarker(marker) {
    if (this.firstStopMarker.name === undefined) {
      this.firstStopMarker.name = marker.name;
      this.firstStopMarker.lat = marker.lat;
      this.firstStopMarker.lng = marker.lng;
      this.firstStopMarker.order = marker.order;
    } else {
      if (marker.order > this.firstStopMarker.order) {
        this.secondStopMarker.name = marker.name;
        this.secondStopMarker.lat = marker.lat;
        this.secondStopMarker.lng = marker.lng;
        this.secondStopMarker.order = marker.order;
        console.log(this.secondStopMarker.order);
        console.log(this.firstStopMarker.order);
        this.stopList = new Array(this.secondStopMarker.order - this.firstStopMarker.order - 1);
        for (let i = this.firstStopMarker.order + 1, j = 0; i < this.secondStopMarker.order; i++, j++) {
          this.stopList[j] = this.markers[i];
        }
      } else {
        alert('Wrong stop order.');
      }
    }
  }

  clearStopFirst() {
    this.firstStopMarker = new MarkerModel();
  }

  clearStopSecond() {
    this.secondStopMarker = new MarkerModel();
  }

}

export class MarkerModel {
  name: String;
  lat: number;
  lng: number;
  draggable: boolean;
  order: number;
}
