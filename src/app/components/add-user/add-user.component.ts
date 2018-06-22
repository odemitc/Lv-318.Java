import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})

export class AddUserComponent {

  user: User = new User();

  constructor(private router: Router, private userService: UserService) {

  }

  createUser(): void {
    this.userService.createUser(this.user)
      .subscribe(data => {
        alert('User created successfully.');
      });

  }

}

