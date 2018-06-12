import {Component, OnInit} from '@angular/core';
import {Chart} from 'chart.js';
import {TransitService} from './transit.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  chart = [];

  constructor(private transitService: TransitService) {
  }

  ngOnInit() {
    this.transitService.getResults('./assets/mockDataBusyHoursDiagram.json')
      .subscribe(res => {
        const CHART = document.getElementById('lineChart');

        const lineChart = new Chart(CHART, {
          type: 'line',
          data: {
            labels: Object.keys(res),
            datasets: [{
              label: 'Busy hours diagram',
              fill: true,
              lineTension: 0.7,
              backgroundColor: 'rgba(75,192,192,0.4)',
              borderColor: 'rgba(75,192,192,1)',
              borderCapStyle: 'butt',
              borderDash: [],
              borderDashOffset: 0.0,
              borderJointStyle: 'miter',
              data: Object.values(res)
            }]
          }
        });
      });
    this.transitService.getResults('./assets/mockDataRatingDiagram.json')
      .subscribe(res => {
        const CHART = document.getElementById('doughnut');

        const doughnut = new Chart(CHART, {
          type: 'doughnut',
          data: {
            labels: ['bad', 'so-so', 'good'],
            datasets: [{
              label: 'Rating diagram',
              fill: true,
              backgroundColor: ['red', 'yellow', 'green'],
              borderColor: 'gray',
              clickable: false,
              borderCapStyle: 'butt',
              borderDash: [],
              borderDashOffset: 0.0,
              data: Object.values(res)
            }]
          }
        });
      });
  }
}

