
export class LoginInfo {
  username: string;
  password: string;
  authorities: string[];
  accessToken: string;
  admin: boolean;
  constructor(username: string, password: string) {
    this.username =  username;
    this.password =  password;
  }
}
