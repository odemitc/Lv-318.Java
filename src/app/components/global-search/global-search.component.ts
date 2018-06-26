import { Component, OnInit, ViewChild, SimpleChanges } from '@angular/core';
import { GlobalSearchService } from '../../services/global-search.service';
import { Transit } from '../../models/transit.model';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { Location } from '@angular/common';

@Component({
  selector: 'app-global-search',
  templateUrl: './global-search.component.html',
  styleUrls: ['./global-search.component.css']
})
export class GlobalSearchComponent implements OnInit {
empty: boolean = true;
emptyTransit: boolean = false;

transits: Transit [];
searchValue: string ="";
displayedColumns = ['name', 'route'];
dataSource = new MatTableDataSource<Transit>();
data: Transit [];
@ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private globalSearchService: GlobalSearchService,
    private location: Location ) { }
 

  ngOnInit(){
    this.empty=true;
    this.emptyTransit=false;
    this.getResults();     
  }


  getResults(): void{
    this.globalSearchService.getResults().subscribe(transits => {
      this.dataSource.data = transits
      if(!(transits.length===0)){
        this.emptyTransit=true;
        this.empty=false;
      }
      if(transits.length===0){
        this.emptyTransit=false;
        this.empty=true;
      }
      this.dataSource.paginator = this.paginator;
    });  
    
  }
  
  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();    
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter=filterValue;    
    
  }
  gotBack(): void {
    this.location.back();
  }
  
}
