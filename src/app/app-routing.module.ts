import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NonExCategoryComponent } from './components/non-ex-category/non-ex-category.component';
import { TransitsComponent } from './components/transits/transits.component';
import { MainComponent } from './components/main/main.component';
import { FeedbackCriteriaComponent } from './components/feedback-criteria/feedback-criteria.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { StopsComponent } from './components/stops/stops.component';
import {StopsGridComponent} from "./components/stops/stops-grid.component";

const routes: Routes = [
  {
    path: 'category/:top/:city', component: NonExCategoryComponent
    // children: [
    //   {
    //     path: ':id', component: TransitsComponent
    //   }
    // ]
  },
  {path: 'category/:top/:city/:id', component: TransitsComponent},

  {path: 'stop/:id', component: StopsComponent},
  {
    path: 'main', component: MainComponent
  },
  {
    path: 'feedback', component: FeedbackCriteriaComponent
  },
  {path: 'user/add', component: AddUserComponent
  },
  {path: 'show-transit-scheme/:id', component: StopsGridComponent}


];

@NgModule({
  imports: [
    [RouterModule.forRoot(routes)]
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
