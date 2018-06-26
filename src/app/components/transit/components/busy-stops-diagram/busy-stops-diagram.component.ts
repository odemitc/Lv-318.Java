import {AfterContentChecked, AfterViewInit, Component, Input} from '@angular/core';
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
  keys;
  values;

  constructor(private diagramService: DiagramService, private stopService: StopService) {
  }

  public updateChartData(stops: Stop[]) {
    if(stops.length >= 2 ) {
      this.chart.destroy();
      this.values.unsubscribe();
      this.stopService.getResults(environment.serverURL + '/feedback/byStop/' + this.id + '?stop-list=' + stops).subscribe(
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
                data: Object.values(res).concat([0, 100])
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

    // this.chart.data.labels.pop();
    // this.chart.update();
    // this.chart.data.labels.push(stops);
    // this.chart.update();
    console.log('update');

  }


  ngOnInit(): void {


    this.values = this.diagramService.getResults(environment.serverURL + '/feedback/byStop/' + this.id + '?stop-list=' + this.stopList).subscribe(
      res => {


    console.log(this.keys);
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
          data: Object.values(res).concat([0, 100])
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

  public removeData(chart) {
    chart.data.labels.pop();
    chart.data.datasets.forEach((dataset) => {
      dataset.data.pop();
    });
    // chart.update();
  }

  public addData(chart, label, data) {
    chart.data.labels.push(label);
    chart.data.datasets.forEach((dataset) => {
      dataset.data.push(data);
    });
    chart.update();
  }
}
