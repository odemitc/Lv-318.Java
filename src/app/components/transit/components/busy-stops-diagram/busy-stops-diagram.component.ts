import {AfterContentChecked, AfterViewInit, Component, Input, OnInit} from '@angular/core';
import {Chart} from 'chart.js';

import {environment} from '../../../../../environments/environment';
import {DiagramService} from '../../../../services/diagram.service';
import {Stop} from '../../../../models/stop.model';
import {StopService} from "../../../../services/stop.service";

@Component({
  selector: 'app-busy-stops-diagram',
  templateUrl: './busy-stops-diagram.component.html',
  styleUrls: ['./busy-stops-diagram.component.css']
})
export class BusyStopsDiagramComponent implements OnInit {
  @Input() id: number;
  @Input() stopList: Stop[];

  chart;
  values;

  constructor(private diagramService: DiagramService, private stopService: StopService) {
  }


  ngAfterViewInit(): void {
    this.diagramService.getResults(environment.serverURL + '/feedback/byStop/' + this.id + '?stop-list=')
      .subscribe(res => {
        const CHART = document.getElementById('lineChart1');

        this.lineChart1 = new Chart(CHART, {
          type: 'line',
          data: {
            labels: Object.keys(res).map(data => data.substring(data.indexOf('=', 2) + 11, data.indexOf(', lat'))),
            datasets: [{
              fill: true,
              lineTension: 0.5,
              backgroundColor: 'rgba(75,192,192,0.4)',
              borderColor: 'rgba(75,192,192,1)',
              borderCapStyle: 'butt',
              borderDash: [],
              borderDashOffset: 0.0,
              borderJointStyle: 'miter',
              data: Object.values(res).concat([0, 100]).map(data => (<number>data).toPrecision(3))
            }]
          },
          options: {
            legend: {
              display: false

            }
          });

        }
      );
    }

  }


  ngOnInit(): void {
    this.values = this.diagramService.getResults(environment.serverURL + '/feedback/byStop/' + this.id + '?stop-list=' + this.stopList).subscribe(
      res => {

    let CHART = document.getElementById('lineChart1');

    this.chart = new Chart(CHART, {
      type: 'line',
      data: {
        labels: Object.keys(res).map(data => data.substring(data.lastIndexOf('=') + 1, data.indexOf(')'))),
        datasets: [{
          fill: true,
          lineTension: 0.6,
          backgroundColor: 'rgba(75,192,192,0.4)',
          borderColor: 'rgba(75,192,192,1)',
          borderCapStyle: 'butt',
          borderDash: [],
          borderDashOffset: 0.0,
          borderJointStyle: 'miter',
          data: Object.values(res).concat([0, 100]).map(data => (<number>data).toPrecision(3))
        }]
      },
      options: {
        legend: {
          display: false
        }
      }
    });

      }
    );

  }

}
