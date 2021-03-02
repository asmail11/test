
export class RegisterInfo {
  name: string;
  username: string;
  email: string;
  password: string;
  gender: string;
  birthDate: any;
  createAt: any;
  role: string[];
  authorities: string[];
  accessToken: string;
  admin: boolean;
 constructor(name: string,
             username: string,
             email: string,
             password: string,
             gender: string,
             birthDate: any,
             createAt: any) {
   this.name = name;
   this.username = username;
   this.email = email;
   this.password = password;
   this.gender = gender;
   this.birthDate = birthDate;
   this.createAt = createAt;
   this.role = ['user'];
 }
}
