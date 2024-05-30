import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlleyListComponent } from './alley-list.component';

describe('AlleyListComponent', () => {
  let component: AlleyListComponent;
  let fixture: ComponentFixture<AlleyListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlleyListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AlleyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
