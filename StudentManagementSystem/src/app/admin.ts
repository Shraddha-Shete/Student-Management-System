export class Admin {
    id!:number;
    firstName!:string;
    lastName!:string;
    mobNo!:string;
    email!:string;
    password!:any;
    confirmPassword!:any;
    passwordMatch(): boolean {
        // console.log('Checking password match:', this.password === this.confirmPassword);
        return this.password === this.confirmPassword;
      }
}
