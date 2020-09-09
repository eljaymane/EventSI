import { Country } from './country.model';
import { Rank } from './rank.model';
import { Contest } from './contest.model';

export class User {
    constructor(
                    private id: number,
                    private username: string,
                    private country: Country,
                    private firstName: string,
                    private lastName: string,
                    private phoneNumber: string,
                    private rank: Rank,
                    private contests:Array<Contest>
                )
                    { 
                        
                    }
}
