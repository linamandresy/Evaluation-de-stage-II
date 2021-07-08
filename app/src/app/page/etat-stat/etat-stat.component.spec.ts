import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EtatStatComponent } from './etat-stat.component';

describe('EtatStatComponent', () => {
  let component: EtatStatComponent;
  let fixture: ComponentFixture<EtatStatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EtatStatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EtatStatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
