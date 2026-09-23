import { TestBed } from '@angular/core/testing';
import { CanMatchFn } from '@angular/router';
import { adminCoursesGuard } from './admin-courses-guard';

describe('adminCoursesGuard', () => {
  const executeGuard: CanMatchFn = (...guardParameters) =>
    TestBed.runInInjectionContext(() => adminCoursesGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
