export class User {
  public userId: string;
  public username: string;
  public email: string;
  public lastLoginDate: Date;
  public lastLoginDateDisplay: Date;
  public joinDate: Date;
  public active: boolean;
  public notLocked: boolean;
  public role: string;
  public authorities: [];

  constructor() {
    this.userId = '';
    this.username = '';
    this.email = '';
    // @ts-ignore
    this.lastLoginDate = null;
    // @ts-ignore
    this.lastLoginDateDisplay = null;
    // @ts-ignore
    this.joinDate = null;
    this.active = false;
    this.notLocked = false;
    this.role = '';
    this.authorities = [];
  }

}
