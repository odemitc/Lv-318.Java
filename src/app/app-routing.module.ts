import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './services/auth/auth.guard';

import { NonExCategoryComponent } from './components/non-ex-category/non-ex-category.component';
import { TransitsComponent } from './components/transits/transits.component';
import { MainComponent } from './components/main/main.component';
import { FeedbackCriteriaComponent } from './components/feedback-criteria/feedback-criteria.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { StopsGridComponent } from './components/stops/stops-grid.component';

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

  {
    path: 'main', component: MainComponent
  },
  {
    path: 'feedback-criteria', component: FeedbackCriteriaComponent
  },
  {
    path: 'user/add', component: AddUserComponent
  },
  {
    path: 'show-transit-scheme/:id', component: StopsGridComponent
  }


];

@NgModule({
  imports: [
    [RouterModule.forRoot(routes)]
  ],
  providers: [AuthGuard],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
