import { TestBed } from '@angular/core/testing';

import { LeagueListService } from './league-list.service';

describe('LeagueListService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LeagueListService = TestBed.get(LeagueListService);
    expect(service).toBeTruthy();
  });
});
