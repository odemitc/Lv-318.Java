import { Component, OnInit } from '@angular/core';
import { TransitService } from '../../services/transit.service';
import { Convert, Transit } from '../../models/transit.model';
import { Observable, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-transits',
  templateUrl: './transits.component.html',
  styleUrls: ['./transits.component.css']
})
export class TransitsComponent implements OnInit {
  private sub: any;
  private id: String;

  transit = new Transit();

  transits: Observable<Transit[]>;

  displayedColumns = ['id', 'name', 'route'];

  constructor(private transitService: TransitService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.sub = this.route.params.forEach(params => {
      this.id = params['id'];
    });
    this.transits = this.transitService.getTransitsByCategoryId(this.id);
  }

  onSubmit() {
    this.transitService.addTransit(this.transit)
      .subscribe(res => console.log(res));
    alert('Transit added: ' + Convert.transitToJson(this.transit));
  }
}
