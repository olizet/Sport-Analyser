import { TestBed } from '@angular/core/testing';

import { FixtureRapportService } from './fixture-rapport.service';

describe('FixtureRapportService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FixtureRapportService = TestBed.get(FixtureRapportService);
    expect(service).toBeTruthy();
  });
});
