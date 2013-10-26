from django.db import models

# Create your models here.

class Birthday(models.Model):
    name = models.CharField(max_length=200)
    date = models.DateField()
    calendarOpt=(
            ('lunar', 'Lunar'),
            ('gregorian', 'Gregorian'),
            )
    calendar = models.CharField(max_length=20, choices=calendarOpt)

    def __unicode__(self):
        return self.name+' '+str(self.date)
