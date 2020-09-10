import { Country } from './country.model';
import { Rank } from './rank.model';
import { Contest } from './contest.model';

export class User {
    constructor(
                    public id: number,
                    public username: string,
                    public password: string,
                    public email: string,
                    public country: Country,
                    public firstName: string,
                    public lastName: string,
                    public phoneNumber: string,
                    public rank: Rank,
                    public contests:Array<Contest>
                )
                    { 
                        
                    }
}
