import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Title } from '@angular/platform-browser';
import { UserService } from '../../auth/service/user.service';
import { SingupComponent } from '../../auth/singup/singup.component';
import { SinginComponent } from '../../auth/singin/singin.component';
import { TokenStorageService } from '../../auth/service/storage.service';
import { UserDto } from 'src/app/modal/rest';
import { RoleDto, BodyFaceHairDto } from '../../modal/rest';
import { BodyFaceHairService } from '../../service/body-face-hair.service';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { filter, map } from 'rxjs/operators';


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {
  userDto: UserDto = {} as UserDto;
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username: string;
  bodyFaceHairs: BodyFaceHairDto[];

  constructor(private dialog: MatDialog, private tokenStorageService: TokenStorageService,
    private userService: UserService, private bodyFaceHairService: BodyFaceHairService,
    private titleService: Title, private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.bodyFaceHairService.findBodyFaceHairs().subscribe((bodyFaceHairs) => {
      this.bodyFaceHairs = bodyFaceHairs;
    })

    this.isLoggedIn = !!this.tokenStorageService.getToken();
    const user = this.tokenStorageService.getUser();
    
    if (this.isLoggedIn && user != null && this.userDto != null) {
      this.userService.findUserById(user.id).subscribe((userDto) => {
        this.userDto = userDto;
        this.userDto.token = user.accessToken;
        this.userDto.roles = user.roles;

        if (this.userDto.admin == true) {
          this.showAdminBoard = true;
        }
        if (this.userDto.admin == false) {
          this.showModeratorBoard = true;
        }
        this.username = user.username;
      })
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
  signin() {
    this.dialog.open(SinginComponent, {
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

  userProfile(idUser: number) {
    this.setDocTitle('Capi skin welcome to user profile');
    window.location.replace(`/user-profile/${idUser}`)
  }
  setDocTitle(title: string) {
    console.log('current title -> ' + this.titleService.getTitle());
    this.titleService.setTitle(title);
  }
}


