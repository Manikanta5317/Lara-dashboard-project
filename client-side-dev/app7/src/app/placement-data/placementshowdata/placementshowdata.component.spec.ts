import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlacementshowdataComponent } from './placementshowdata.component';

describe('PlacementshowdataComponent', () => {
  let component: PlacementshowdataComponent;
  let fixture: ComponentFixture<PlacementshowdataComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PlacementshowdataComponent]
    });
    fixture = TestBed.createComponent(PlacementshowdataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
