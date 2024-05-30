import { TestBed } from '@angular/core/testing';

import { AlleyService } from './alley.service';

describe('AlleyService', () => {
  let service: AlleyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AlleyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
