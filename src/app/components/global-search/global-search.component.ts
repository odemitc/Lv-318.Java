import { Component, OnInit, ViewChild, SimpleChanges, OnChanges } from '@angular/core';
import { GlobalSearchService } from '../../services/global-search.service';
import { Transit } from '../../models/transit.model';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { Location } from '@angular/common';

@Component({
  selector: 'app-global-search',
  templateUrl: './global-search.component.html',
  styleUrls: ['./global-search.component.css']
})
export class GlobalSearchComponent implements OnInit, OnChanges {
empty: boolean = true;
transits: Transit [];
searchValue: string ="";
displayedColumns = ['name', 'route'];
dataSource = new MatTableDataSource();

@ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private globalSearchService: GlobalSearchService,
    private location: Location, ) { }
 

  ngOnInit(){
    this.getResults();     
  }
  ngOnChanges(changes: SimpleChanges) {
    this.empty=true;
    this.getResults();        
     
  }

  getResults(): void{
    this.globalSearchService.getResults().subscribe(transits => this.dataSource.data = transits);
    if(!(this.dataSource.data=null)){
      this.empty=false;
    }
    this.dataSource.paginator = this.paginator;
  }
  
  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();    
    this.dataSource.filter=filterValue;    
    this.dataSource.filterPredicate = (data, filter) =>
    JSON.stringify(data).includes(filter);
  }
  gotBack(): void {
    this.location.back();
  }
}
