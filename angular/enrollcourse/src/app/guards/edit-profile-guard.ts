import { CanDeactivateFn } from '@angular/router';
import { EditProfile } from '../page/edit-profile/edit-profile';


export const editProfileGuard: CanDeactivateFn<EditProfile> = (
  component
) => {
  
  if(component.unsavedchanges()){
    return confirm('you have some unsaved changes !! still do you want to leave');
  }
  return true;
};
