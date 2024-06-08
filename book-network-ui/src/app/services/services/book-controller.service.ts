/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { approveReturnedBorrowBook } from '../fn/book-controller/approve-returned-borrow-book';
import { ApproveReturnedBorrowBook$Params } from '../fn/book-controller/approve-returned-borrow-book';
import { BookResponse } from '../models/book-response';
import { borrowBookController } from '../fn/book-controller/borrow-book-controller';
import { BorrowBookController$Params } from '../fn/book-controller/borrow-book-controller';
import { findAllBooks } from '../fn/book-controller/find-all-books';
import { FindAllBooks$Params } from '../fn/book-controller/find-all-books';
import { findAllBorrowedBooksController } from '../fn/book-controller/find-all-borrowed-books-controller';
import { FindAllBorrowedBooksController$Params } from '../fn/book-controller/find-all-borrowed-books-controller';
import { findAllForOwnerController } from '../fn/book-controller/find-all-for-owner-controller';
import { FindAllForOwnerController$Params } from '../fn/book-controller/find-all-for-owner-controller';
import { findAllReturnedBooksController } from '../fn/book-controller/find-all-returned-books-controller';
import { FindAllReturnedBooksController$Params } from '../fn/book-controller/find-all-returned-books-controller';
import { findBookById } from '../fn/book-controller/find-book-by-id';
import { FindBookById$Params } from '../fn/book-controller/find-book-by-id';
import { PageResponseBookResponse } from '../models/page-response-book-response';
import { PageResponseBorrowedBookResponse } from '../models/page-response-borrowed-book-response';
import { returnBorrowedBook } from '../fn/book-controller/return-borrowed-book';
import { ReturnBorrowedBook$Params } from '../fn/book-controller/return-borrowed-book';
import { saveBook } from '../fn/book-controller/save-book';
import { SaveBook$Params } from '../fn/book-controller/save-book';
import { updateArchiveStatus } from '../fn/book-controller/update-archive-status';
import { UpdateArchiveStatus$Params } from '../fn/book-controller/update-archive-status';
import { updateShareableStatus } from '../fn/book-controller/update-shareable-status';
import { UpdateShareableStatus$Params } from '../fn/book-controller/update-shareable-status';
import { uploadBookCoverPicture } from '../fn/book-controller/upload-book-cover-picture';
import { UploadBookCoverPicture$Params } from '../fn/book-controller/upload-book-cover-picture';

@Injectable({ providedIn: 'root' })
export class BookControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `findAllBooks()` */
  static readonly FindAllBooksPath = '/book';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllBooks()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllBooks$Response(params?: FindAllBooks$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseBookResponse>> {
    return findAllBooks(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllBooks$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllBooks(params?: FindAllBooks$Params, context?: HttpContext): Observable<PageResponseBookResponse> {
    return this.findAllBooks$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseBookResponse>): PageResponseBookResponse => r.body)
    );
  }

  /** Path part for operation `saveBook()` */
  static readonly SaveBookPath = '/book';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `saveBook()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveBook$Response(params: SaveBook$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return saveBook(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `saveBook$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveBook(params: SaveBook$Params, context?: HttpContext): Observable<number> {
    return this.saveBook$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `uploadBookCoverPicture()` */
  static readonly UploadBookCoverPicturePath = '/book/cover/{bookId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `uploadBookCoverPicture()` instead.
   *
   * This method sends `miultipart/form-data` and handles request body of type `miultipart/form-data`.
   */
  uploadBookCoverPicture$Response(params: UploadBookCoverPicture$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
    return uploadBookCoverPicture(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `uploadBookCoverPicture$Response()` instead.
   *
   * This method sends `miultipart/form-data` and handles request body of type `miultipart/form-data`.
   */
  uploadBookCoverPicture(params: UploadBookCoverPicture$Params, context?: HttpContext): Observable<{
}> {
    return this.uploadBookCoverPicture$Response(params, context).pipe(
      map((r: StrictHttpResponse<{
}>): {
} => r.body)
    );
  }

  /** Path part for operation `borrowBookController()` */
  static readonly BorrowBookControllerPath = '/book/borrow/{bookId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `borrowBookController()` instead.
   *
   * This method doesn't expect any request body.
   */
  borrowBookController$Response(params: BorrowBookController$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return borrowBookController(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `borrowBookController$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  borrowBookController(params: BorrowBookController$Params, context?: HttpContext): Observable<number> {
    return this.borrowBookController$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `updateShareableStatus()` */
  static readonly UpdateShareableStatusPath = '/book/shareable/{book-id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateShareableStatus()` instead.
   *
   * This method doesn't expect any request body.
   */
  updateShareableStatus$Response(params: UpdateShareableStatus$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return updateShareableStatus(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateShareableStatus$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  updateShareableStatus(params: UpdateShareableStatus$Params, context?: HttpContext): Observable<number> {
    return this.updateShareableStatus$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `returnBorrowedBook()` */
  static readonly ReturnBorrowedBookPath = '/book/borrow/return/{bookId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `returnBorrowedBook()` instead.
   *
   * This method doesn't expect any request body.
   */
  returnBorrowedBook$Response(params: ReturnBorrowedBook$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return returnBorrowedBook(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `returnBorrowedBook$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  returnBorrowedBook(params: ReturnBorrowedBook$Params, context?: HttpContext): Observable<number> {
    return this.returnBorrowedBook$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `approveReturnedBorrowBook()` */
  static readonly ApproveReturnedBorrowBookPath = '/book/borrow/return/approve/{bookId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `approveReturnedBorrowBook()` instead.
   *
   * This method doesn't expect any request body.
   */
  approveReturnedBorrowBook$Response(params: ApproveReturnedBorrowBook$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return approveReturnedBorrowBook(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `approveReturnedBorrowBook$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  approveReturnedBorrowBook(params: ApproveReturnedBorrowBook$Params, context?: HttpContext): Observable<number> {
    return this.approveReturnedBorrowBook$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `updateArchiveStatus()` */
  static readonly UpdateArchiveStatusPath = '/book/archive/{book-id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateArchiveStatus()` instead.
   *
   * This method doesn't expect any request body.
   */
  updateArchiveStatus$Response(params: UpdateArchiveStatus$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return updateArchiveStatus(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateArchiveStatus$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  updateArchiveStatus(params: UpdateArchiveStatus$Params, context?: HttpContext): Observable<number> {
    return this.updateArchiveStatus$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `findBookById()` */
  static readonly FindBookByIdPath = '/book/{book-id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findBookById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findBookById$Response(params: FindBookById$Params, context?: HttpContext): Observable<StrictHttpResponse<BookResponse>> {
    return findBookById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findBookById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findBookById(params: FindBookById$Params, context?: HttpContext): Observable<BookResponse> {
    return this.findBookById$Response(params, context).pipe(
      map((r: StrictHttpResponse<BookResponse>): BookResponse => r.body)
    );
  }

  /** Path part for operation `findAllReturnedBooksController()` */
  static readonly FindAllReturnedBooksControllerPath = '/book/returned';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllReturnedBooksController()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllReturnedBooksController$Response(params?: FindAllReturnedBooksController$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseBorrowedBookResponse>> {
    return findAllReturnedBooksController(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllReturnedBooksController$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllReturnedBooksController(params?: FindAllReturnedBooksController$Params, context?: HttpContext): Observable<PageResponseBorrowedBookResponse> {
    return this.findAllReturnedBooksController$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseBorrowedBookResponse>): PageResponseBorrowedBookResponse => r.body)
    );
  }

  /** Path part for operation `findAllForOwnerController()` */
  static readonly FindAllForOwnerControllerPath = '/book/owner';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllForOwnerController()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllForOwnerController$Response(params?: FindAllForOwnerController$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseBookResponse>> {
    return findAllForOwnerController(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllForOwnerController$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllForOwnerController(params?: FindAllForOwnerController$Params, context?: HttpContext): Observable<PageResponseBookResponse> {
    return this.findAllForOwnerController$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseBookResponse>): PageResponseBookResponse => r.body)
    );
  }

  /** Path part for operation `findAllBorrowedBooksController()` */
  static readonly FindAllBorrowedBooksControllerPath = '/book/borrowed';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllBorrowedBooksController()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllBorrowedBooksController$Response(params?: FindAllBorrowedBooksController$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseBorrowedBookResponse>> {
    return findAllBorrowedBooksController(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllBorrowedBooksController$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllBorrowedBooksController(params?: FindAllBorrowedBooksController$Params, context?: HttpContext): Observable<PageResponseBorrowedBookResponse> {
    return this.findAllBorrowedBooksController$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseBorrowedBookResponse>): PageResponseBorrowedBookResponse => r.body)
    );
  }

}
