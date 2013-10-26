from django.forms import ModelForm
from birthday.models import Birthday

class BirthdayForm(ModelForm):
    class Meta:
        model = Birthday

