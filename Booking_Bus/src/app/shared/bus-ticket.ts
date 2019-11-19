import { Bus } from './bus';
import { Status } from './status';

export class BusTicket {
    idticket: number;
    nameseat: string;
    status: Status;
    scheduleday: string;
    bus: Bus;
} 