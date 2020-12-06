import { TestBed } from '@angular/core/testing';

import { ApimodalService } from './apimodal.service';

describe('ApimodalService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApimodalService = TestBed.get(ApimodalService);
    expect(service).toBeTruthy();
  });
});
