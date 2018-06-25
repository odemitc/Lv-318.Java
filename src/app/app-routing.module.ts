import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './services/auth/auth.guard';

import { NonExCategoryComponent } from './components/non-ex-category/non-ex-category.component';
import { TransitsComponent } from './components/transits/transits.component';
import { MainComponent } from './components/main/main.component';
import { FeedbackCriteriaComponent } from './components/feedback-criteria/feedback-criteria.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { AddQuestionComponent } from './components/feedback-criteria/add-question/add-question.component';
import {UserLoginComponent} from './components/user-login/user-login.component';
import { AddFeedbackComponent } from './components/transit/components/add-feedback/add-feedback.component';
import {StopsGridComponent} from './components/transit/stops-grid.component';
import { OneFeedbackCriteriaComponent } from './components/feedback-criteria/one-feedback-criteria/one-feedback-criteria.component';
import { AddFeedbackCriteriaComponent } from './components/feedback-criteria/add-feedback-criteria/add-feedback-criteria.component';

const routes: Routes = [
  {path: 'category/:top/:city', component: NonExCategoryComponent},
  {path: 'category/:top/:city/:id', component: TransitsComponent},
  {path: 'main', component: MainComponent},
  {path: 'feedback-criteria', component: FeedbackCriteriaComponent},
  {path: 'feedback-criteria/add-question' , component: AddQuestionComponent},
  {path: 'user/add', component: AddUserComponent},
  {path: 'stops/:city/:id', component: StopsGridComponent},
  {path: 'user/login', component: UserLoginComponent},
  {path: 'feedback-criteria', component: FeedbackCriteriaComponent},
  {path: 'feedback-criteria/add-feedback-criteria', component: AddFeedbackCriteriaComponent},
  {path: 'feedback-criteria/:id', component: OneFeedbackCriteriaComponent},
  {path: 'show-transit-scheme/:id/:categoryId', component: StopsGridComponent},
  {path: 'feedback', component: AddFeedbackComponent}

];


@NgModule({
  imports: [
    [RouterModule.forRoot(routes)]
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
