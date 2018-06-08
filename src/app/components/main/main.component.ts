import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  imageSources: String[] = ['../../../assets/1.png',
    '../../../assets/2.png',
    '../../../assets/3.png'
  ];

  constructor() {
  }

  ngOnInit() {
  }

}
