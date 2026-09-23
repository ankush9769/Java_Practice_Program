import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Traditionalreactiveform } from './traditionalreactiveform';

describe('Traditionalreactiveform', () => {
  let component: Traditionalreactiveform;
  let fixture: ComponentFixture<Traditionalreactiveform>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Traditionalreactiveform],
    }).compileComponents();

    fixture = TestBed.createComponent(Traditionalreactiveform);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
