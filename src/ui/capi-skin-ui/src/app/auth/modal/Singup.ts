
export class SingUp {
  name: string;
  username: string;
  email: string;
  password: string;
  gender: string;
  birthDate: any;
  createAt: any;
  role: string[];
  roles: string[];
  accessToken: string;
  admin: boolean;
 constructor(username: string,
             email: string,
             password: string) {
   this.username = username;
   this.email = email;
   this.password = password;
   this.role = ['admin'];
 }
public getRoles(roles: string[]) {
   this.roles = roles;
}
}
