import { TestBed } from '@angular/core/testing';

import { HsService } from './hs.service';

describe('HsService', () => {
  let service: HsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
