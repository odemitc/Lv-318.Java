import {Component, OnInit, ViewChild} from '@angular/core';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

import { Stop } from '../../models/stop.model';
import { StopService } from '../../services/stop.service';
import {BusyHoursDiagramComponent} from './components/busy-hours-diagram/busy-hours-diagram.component';


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
  displayedColumns = ['id', 'street'];
  @ViewChild(BusyHoursDiagramComponent) busyHoursDiadram: BusyHoursDiagramComponent;

  constructor(private stopService: StopService, private route: ActivatedRoute) {
  }

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
