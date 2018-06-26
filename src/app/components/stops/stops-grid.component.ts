import { Component, OnInit } from '@angular/core';
import { Stop } from '../../models/stop.model';
import { ActivatedRoute } from '@angular/router';
import { StopService } from '../../services/stop.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-stops-grid',
  templateUrl: './stops-grid.component.html',
  styleUrls: ['./stops-grid.component.css']
})
export class StopsGridComponent implements OnInit {

  private sub: any;
  public idTransit: number;
  stopsList: Observable<Stop[]>;

  constructor(private stopService: StopService, private route: ActivatedRoute) {
  
  }

  ngOnInit() {
    this.sub = this.route.params.forEach(params => {
      this.idTransit = params['id'];
    });
    this.stopsList = this.stopService.getStopsByTransitId(this.idTransit);
  }
}

