import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FixtureRapportComponent } from './fixture-rapport.component';

describe('FixtureRapportComponent', () => {
  let component: FixtureRapportComponent;
  let fixture: ComponentFixture<FixtureRapportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FixtureRapportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FixtureRapportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
