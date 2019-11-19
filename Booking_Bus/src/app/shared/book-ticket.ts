import {StatusBook} from "./book-status"
import {Users} from "./users"
import {BusTicket} from "./bus-ticket"

export class TicketBook{
    idbooksticket:number;
    users:Users;
    ticket:BusTicket;
    statusbook:StatusBook;
    cancleday:String;
    bookday:String;
}