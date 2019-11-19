import { TestBed, inject } from '@angular/core/testing';

import { BusTicketService } from './bus-ticket.service';

describe('BusTicketService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BusTicketService]
    });
  });

  it('should be created', inject([BusTicketService], (service: BusTicketService) => {
    expect(service).toBeTruthy();
  }));
});
