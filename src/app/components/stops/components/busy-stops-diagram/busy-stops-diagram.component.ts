import {AfterViewInit, Component, Input, OnInit} from '@angular/core';
import {Chart} from 'chart.js';

import {environment} from '../../../../../environments/environment';
import {DiagramService} from '../../../../services/diagram.service';
import {Stop} from "../../../../models/stop.model";

@Component({
  selector: 'app-busy-stops-diagram',
  templateUrl: './busy-stops-diagram.component.html',
})
export class BusyStopsDiagramComponent implements  OnInit {
  @Input() id: number;
  @Input() stopList: Stop[];

  constructor(private diagramService: DiagramService) {
  }

  ngOnInit(): void {
    this.diagramService.getResults(environment.serverURL + '/feedback/byStop/' + this.id + '?stop-list=' + this.stopList)
      .subscribe(res => {
        const CHART = document.getElementById('lineChart1');

        const lineChart1 = new Chart(CHART, {
          type: 'line',
          data: {
            labels: Object.keys(res),
            datasets: [{
              fill: true,
              lineTension: 0.6,
              backgroundColor: 'rgba(75,192,192,0.4)',
              borderColor: 'rgba(75,192,192,1)',
              borderCapStyle: 'butt',
              borderDash: [],
              borderDashOffset: 0.0,
              borderJointStyle: 'miter',
              data: Object.values(res)
            }]
          },
          options: {
            legend: {
              display: false
            }
          }
        });
      });
  }

}
