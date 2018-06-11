import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { DataSource } from '@angular/cdk/collections';
import { ActivatedRoute } from '@angular/router';

import { Stop } from '../../models/stop.model';
import {StopService} from "../../services/stop.service";
import {TransitService} from "../../services/transit.service";
import {Transit} from "../../models/transit.model";
import {TransitDataSource} from "../transits/transits.component";

@Component({
  selector: 'app-stops',
  templateUrl: './stops.component.html',
  styleUrls: ['./stops.component.css']
})
export class StopsComponent implements OnInit {
  private sub: any;
  public idTransit: number;

  stop = new Stop();

  stopsList: Observable<Stop[]>;

  dataSource = new StopDataSource(this.stopService, this);
  displayedColumns = ['id', 'street'];

  constructor(private stopService: StopService,  private route: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.route.params.forEach(params => {
      this.idTransit = params['id'];
    });
   this.stopsList = this.stopService.getStopsByTransitId(this.idTransit);
  }

  onSubmit() {
    this.stopService.addStop(this.stop, this.idTransit)
      .subscribe(res => console.log(res));
    alert('Stop added: ');
  }
}
export class StopDataSource extends DataSource<any> {
  constructor(private stopService: StopService, private stopComponent : StopsComponent) {
    super();
  }
  connect(): Observable<Stop[]> {
    return this.stopService.getStopsByTransitId(this.stopComponent.idTransit);
  }
  disconnect() {}
}

