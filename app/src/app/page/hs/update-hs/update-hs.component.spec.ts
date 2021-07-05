import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateHsComponent } from './update-hs.component';

describe('UpdateHsComponent', () => {
  let component: UpdateHsComponent;
  let fixture: ComponentFixture<UpdateHsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateHsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateHsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
