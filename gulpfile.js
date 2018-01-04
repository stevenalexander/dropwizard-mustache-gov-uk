var gulp = require('gulp')
var rename = require('gulp-rename')

gulp.task('update_govuk_template_mustache', function () {
  gulp.src('node_modules/govuk_template_mustache/assets/**/*')
    .pipe(gulp.dest('src/main/resources/assets', { overwrite: true }))

  gulp.src('node_modules/govuk_template_mustache/views/layouts/govuk_template.html')
    .pipe(rename('govuk_template.mustache'))
    .pipe(gulp.dest('src/main/resources/com/example/views/govuk', { overwrite: true }))
})

gulp.task('default', ['update_govuk_template_mustache'])
