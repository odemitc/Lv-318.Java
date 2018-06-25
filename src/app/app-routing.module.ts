import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './services/auth/auth.guard';

import { NonExCategoryComponent } from './components/non-ex-category/non-ex-category.component';
import { TransitsComponent } from './components/transits/transits.component';
import { MainComponent } from './components/main/main.component';
import { FeedbackCriteriaComponent } from './components/feedback-criteria/feedback-criteria.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { StopsGridComponent } from './components/transit/stops-grid.component';
import { QuestionComponent } from './components/question/question.component';
import { AddQuestionComponent } from './components/question/add-question/add-question.component';
import { OneQuestionComponent } from './components/question/one-question/one-question.component';
import { UserLoginComponent } from './components/user-login/user-login.component';

const routes: Routes = [
  {path: 'category/:top/:city', component: NonExCategoryComponent},
  {path: 'category/:top/:city/:id', component: TransitsComponent},
  {path: 'main', component: MainComponent},
  {path: 'feedback-criteria', component: FeedbackCriteriaComponent},
  {path: 'question', component: QuestionComponent},
  {path: 'question/add-question', component: AddQuestionComponent},
  {path: 'question/:id', component: OneQuestionComponent},
  {path: 'user/add', component: AddUserComponent},
  {path: 'stops/:city/:id', component: StopsGridComponent},
  {path: 'user/login', component: UserLoginComponent},
  {path: 'show-transit-scheme/:id', component: StopsGridComponent}
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