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
  public stop = new Stop();

  stopsList: Observable<Stop[]>;

  constructor(private stopService: StopService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.sub = this.route.params.forEach(params => {
      this.idTransit = params['id'];
    });
    this.stopsList = this.stopService.getStopsByTransitId(this.idTransit);
  }

// tiles: {text: string, cols: number, rows: number, color: string}[] = [
//   {text: 'One', cols: 3, rows: 1, color: 'lightblue'},
//   {text: 'Two', cols: 1, rows: 2, color: 'lightgreen'},
//   {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
//   {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
// ];

// dogs: {name: string, human: string}[] = [
//   {name: 'Porter', human: 'Kara'},
//   {name: 'Mal', human: 'Jeremy'},
//   {name: 'Koby', human: 'Igor'},
//   {name: 'Razzle', human: 'Ward'},
//   {name: 'Molly', human: 'Rob'},
//   {name: 'Husi', human: 'Matias'},
// ];

}

