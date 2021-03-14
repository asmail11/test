import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { SingupComponent } from './auth/singup/singup.component';
import { TokenStorageService } from './auth/service/storage.service';
import { UserService } from './auth/service/user.service';
import { UserDto, RoleDto } from './modal/rest';
import { Router } from '@angular/router';
import { AuthService } from './auth/service/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  private roles: RoleDto[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username: string;
  userDto: UserDto = {} as UserDto;

  constructor(private tokenStorageService: TokenStorageService, private dialog: MatDialog,
    private userService: UserService, private authService: AuthService) { }

  ngOnInit(): void {  
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    
    const user = this.tokenStorageService.getUser();
    if (this.isLoggedIn && user!=null) {
    
     this.userService.findUserById(user.id).subscribe((userDto) => {
      this.userDto = userDto;
      this.roles = this.userDto.roles;
      this.roles.forEach(role => {
        if (role.name == 'ROLE_ADMIN') {
          this.showAdminBoard = true;
        }
        if (role.name == 'ROLE_USER') {
          this.showModeratorBoard = true;
        }
      })
    })

     this.username = user.username;
   }
  }

  signup() {
    this.dialog.open(SingupComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'auth-dialog-container',
      width: '300px'
    });
  }
  logout() {
    this.tokenStorageService.signOut();
    window.location.replace('/home');
  }
}
