import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import 'hammerjs';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
// import { InMemoryDataService }  from './in-memory-data.service';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from 'src/app/app-routing.module';
import {ExcategoryComponent} from './components/excategory/excategory.component';
// import 'hammerjs';
import {
  MatAutocompleteModule,
  MatBadgeModule,
  MatBottomSheetModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule, MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatTreeModule,
} from '@angular/material';
import {FormsModule} from '@angular/forms';
import {SidenavComponent} from './components/sidenav/sidenav.component';
import {ExcategoryService} from './services/excategory.service';
import { MenuComponent } from './components/menu/menu.component';
import { NonExCategoryComponent } from './components/non-ex-category/non-ex-category.component';
import { TransitsComponent } from './components/transits/transits.component';
import { MainComponent } from './components/main/main.component';
import {SlideshowModule} from 'ng-simple-slideshow';
import {FeedbackCriteriaComponent} from './components/feedback-criteria/feedback-criteria.component';
import {AddFeedbackCriteriaComponent} from './components/feedback-criteria/addFC/add-feedback-criteria.component';
import {UserService} from './services/user.service';

import {AddUserComponent} from './components/add-user/add-user.component';



@NgModule({
  declarations: [
    AppComponent,
    ExcategoryComponent,
    SidenavComponent,
    MenuComponent,
    NonExCategoryComponent,
    TransitsComponent,
    MainComponent,
    FeedbackCriteriaComponent,
    AddFeedbackCriteriaComponent,
    AddUserComponent
  ],
  exports: [
    MatAutocompleteModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule
  ],
  imports: [
    BrowserModule, BrowserAnimationsModule, MatSidenavModule,
    HttpClientModule,
    AppRoutingModule,
    MatTableModule,
    MatMenuModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatToolbarModule,
    SlideshowModule
  ],
  providers: [ExcategoryService ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
