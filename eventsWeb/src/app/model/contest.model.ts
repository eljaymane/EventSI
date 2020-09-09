import { User } from './user.model';
import { Prize } from './prize.model';

export class Contest {
        constructor (
                        private id:number,
                        private users:Array<User>,
                        private contestName: string,
                        private dateStart:Date ,
                        private dateEnd:Date,
                        private prize:Prize

                    ) 
                        {
                            
                        }
}