import { Component } from '@angular/core';
import {AuthenticationRequest} from "../../services/models/authentication-request";
import {FormsModule} from "@angular/forms";
import {Router} from "express";
import {AuthenticationControllerService} from "../../services/services/authentication-controller.service";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  authRequest: AuthenticationRequest = {email: '', password: ''}
  errorMsg: Array<string> = [];
  constructor(
    private router: Router,
    private authService: AuthenticationControllerService

              ) {
  }

  login() {
    this.errorMsg = [];
    this.authService.login({
      body: this.authRequest
      // where user goes after login
    }).subscribe({
      next: () => {
        // todo save the token
        this.router.route(['book']);
      },
      error: (error: any) => {
        console.log(error);
      }
    });
  }

  register() {
    this.router.route(['register']);
      //
  }
}
