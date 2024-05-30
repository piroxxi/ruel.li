import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlleyDetailsComponent } from './alley-details.component';

describe('AlleyDetailComponent', () => {
  let component: AlleyDetailsComponent;
  let fixture: ComponentFixture<AlleyDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlleyDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlleyDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
