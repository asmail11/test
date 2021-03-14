
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router, Route } from '@angular/router';
import { AuthService } from './auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay, take } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { of } from 'rxjs';

@Injectable()
export class AuthInterceptor implements CanActivate {

  constructor(private authService: AuthService, private router: Router, private snackBar: MatSnackBar) {

  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if(this.authService.isLoggedIn !== true) {
      this.snackBar
      .open(
         'You are not allowed to view this page.',
        'ok',
        { duration: 1000, panelClass: ['mat-toolbar', 'mat-accent'] }
      )
      .afterDismissed()
      .pipe(delay(0))
      .subscribe(() => {
        window.location.reload();
      });
      this.router.navigate(['home'])
    }
    return true;
  }
}

