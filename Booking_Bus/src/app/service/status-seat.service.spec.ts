import { TestBed, inject } from '@angular/core/testing';

import { StatusSeatService } from './status-seat.service';

describe('StatusSeatService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StatusSeatService]
    });
  });

  it('should be created', inject([StatusSeatService], (service: StatusSeatService) => {
    expect(service).toBeTruthy();
  }));
});
