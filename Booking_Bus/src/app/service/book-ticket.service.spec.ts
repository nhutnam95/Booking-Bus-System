import { TestBed, inject } from '@angular/core/testing';

import { BookTicketService } from './book-ticket.service';

describe('BookTicketService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BookTicketService]
    });
  });

  it('should be created', inject([BookTicketService], (service: BookTicketService) => {
    expect(service).toBeTruthy();
  }));
});
