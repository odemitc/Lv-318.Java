import { Component, OnInit } from '@angular/core';
import { TransitService } from '../../services/transit.service';
import { Convert, Transit } from '../../models/transit.model';
import { Observable } from 'rxjs';
import { DataSource } from '@angular/cdk/collections';
import { ActivatedRoute } from '@angular/router';
import { Category } from '../../models/category.model';

@Component({
  selector: 'app-transits',
  templateUrl: './transits.component.html',
  styleUrls: ['./transits.component.css']
})
export class TransitsComponent implements OnInit {
  private sub: any;
  private id: String;

  transit = new Transit(new Category());

  transits: Observable<Transit[]>;

  dataSource = new TransitDataSource(this.transitService);
  displayedColumns = ['id', 'name', 'category_id', 'category_name', 'nextLevelCategory_id', 'nextLevelCategory_name'];

  constructor(private transitService: TransitService,  private route: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.route.params.forEach(params => {
      this.id = params['id'];
    });
   this.transits = this.transitService.getTransitsById(this.id);
  }

  onSubmit() {
    this.transitService.addTransit(this.transit)
      .subscribe(res => console.log(res));
    alert('Transit added: ' + Convert.transitToJson(this.transit));
  }
}

export class TransitDataSource extends DataSource<any> {
  constructor(private transitService: TransitService) {
    super();
  }
  connect(): Observable<Transit[]> {
    return this.transitService.getTransits();
  }
  disconnect() {}
}
